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

package sonata.kernel.adaptor.commons.nsd;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionPoint {

  public enum Interface {
    INTERFACE("interface");
    private final String name;

    Interface(String name) {
      this.name = name;
    }

    public String toString() {
      return this.name;
    }
  }

  private String id;
  private Interface type;
  @JsonProperty("virtua_link_reference")
  private String virtualLinkReference;

  public String getId() {
    return id;
  }

  public Interface getType() {
    return type;
  }

  public String getVirtual_link_reference() {
    return virtualLinkReference;
  }
}
