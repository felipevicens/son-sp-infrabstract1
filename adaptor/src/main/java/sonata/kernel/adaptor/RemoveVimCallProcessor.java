/**
 * @author Dario Valocchi (Ph.D.)
 * @mail d.valocchi@ucl.ac.uk
 * 
 *       Copyright 2016 [Dario Valocchi]
 * 
 *       Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *       except in compliance with the License. You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *       Unless required by applicable law or agreed to in writing, software distributed under the
 *       License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *       either express or implied. See the License for the specific language governing permissions
 *       and limitations under the License.
 * 
 */

package sonata.kernel.adaptor;

import org.json.JSONObject;
import org.json.JSONTokener;

import sonata.kernel.adaptor.messaging.ServicePlatformMessage;
import sonata.kernel.adaptor.wrapper.WrapperBay;

import java.util.Observable;

public class RemoveVimCallProcessor extends AbstractCallProcessor {

  /**
   * Generate a CallProcessor to process an API call to create a new VIM wrapper
   * 
   * @param message the API call message
   * @param sid the session ID of thi API call
   * @param mux the Adaptor Mux to which send responses.
   */
  public RemoveVimCallProcessor(ServicePlatformMessage message, String sid, AdaptorMux mux) {
    super(message, sid, mux);

  }

  @Override
  public boolean process(ServicePlatformMessage message) {
    // process json message to get the wrapper type and UUID
    // and de-register it
    boolean out = true;
    JSONTokener tokener = new JSONTokener(message.getBody());
    JSONObject jsonObject = (JSONObject) tokener.nextValue();
    String uuid = jsonObject.getString("uuid");
    String type = jsonObject.getString("wr_type");
    String output = null;
    if (type.equals("compute")) {
      output = WrapperBay.getInstance().removeComputeWrapper(uuid);
    }
    if (type.equals("storage")) {
      // TODO
      output = "";
    }
    if (type.equals("network")) {
      // TODO
      output = "";
    }
    this.sendMessage(output);
    return out;
  }

  private void sendMessage(String message) {
    ServicePlatformMessage spMessage = new ServicePlatformMessage(message,
        this.getMessage().getTopic(), this.getMessage().getSid());
    this.sendToMux(spMessage);
  }

  @Override
  public void update(Observable observable, Object arg) {
    // This call does not need to be updated by any observable (wrapper).
  }
}
