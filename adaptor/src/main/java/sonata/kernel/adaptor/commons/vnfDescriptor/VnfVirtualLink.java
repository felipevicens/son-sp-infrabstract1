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

package sonata.kernel.adaptor.commons.vnfDescriptor;


import com.fasterxml.jackson.annotation.JsonProperty;

import sonata.kernel.adaptor.commons.serviceDescriptor.VirtualLink.ConnectivityType;

import java.util.ArrayList;

public class VnfVirtualLink {


  private String id;
  @JsonProperty("connectivity_type")
  private ConnectivityType connectivityType;
  @JsonProperty("connection_points_reference")
  private ArrayList<String> connectionPointsReference;
  private boolean access;
  @JsonProperty("external_access")
  private boolean externalAccess;
  @JsonProperty("root_requirement")
  private String rootRequirement;
  @JsonProperty("leaf_requirement")
  private String leafRequirement;
  private boolean dhcp;
  private String qos;

  public String getId() {
    return id;
  }

  public ConnectivityType getConnectivity_type() {
    return connectivityType;
  }

  public ArrayList<String> getConnection_points_reference() {
    return connectionPointsReference;
  }

  public boolean isAccess() {
    return access;
  }

  public boolean isExternal_access() {
    return externalAccess;
  }

  public String getRoot_requirement() {
    return rootRequirement;
  }

  public String getLeaf_requirement() {
    return leafRequirement;
  }

  public boolean isDhcp() {
    return dhcp;
  }

  public String getQos() {
    return qos;
  }
}