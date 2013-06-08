/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.rest.api.runtime.process;

import java.util.List;

import org.activiti.rest.api.engine.variable.QueryVariable;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;


/**
 * @author Frederik Heremans
 */
public class ProcessInstanceQueryRequest {

  private String processInstanceId;
  private String processBusinessKey;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String superProcessInstanceId;
  private String subProcessInstanceId;
  private String involvedUser;
  private Boolean suspended;
  private List<QueryVariable> variables;
  
  public String getProcessInstanceId() {
    return processInstanceId;
  }
  
  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }
  
  public String getProcessBusinessKey() {
    return processBusinessKey;
  }
  
  public void setProcessBusinessKey(String processBusinessKey) {
    this.processBusinessKey = processBusinessKey;
  }
  
  public String getProcessDefinitionId() {
    return processDefinitionId;
  }
  
  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }
  
  public String getProcessDefinitionKey() {
    return processDefinitionKey;
  }
  
  public void setProcessDefinitionKey(String processDefinitionKey) {
    this.processDefinitionKey = processDefinitionKey;
  }
  
  public String getSuperProcessInstanceId() {
    return superProcessInstanceId;
  }
  
  public void setSuperProcessInstanceId(String superProcessInstanceId) {
    this.superProcessInstanceId = superProcessInstanceId;
  }
  
  public String getSubProcessInstanceId() {
    return subProcessInstanceId;
  }
  
  public void setSubProcessInstanceId(String subProcessInstanceId) {
    this.subProcessInstanceId = subProcessInstanceId;
  }
  
  public String getInvolvedUser() {
    return involvedUser;
  }
  
  public void setInvolvedUser(String involvedUser) {
    this.involvedUser = involvedUser;
  }
  
  public Boolean getSuspended() {
    return suspended;
  }
  
  public void setSuspended(Boolean suspended) {
    this.suspended = suspended;
  }
  
  @JsonTypeInfo(use=Id.CLASS, defaultImpl=QueryVariable.class)  
  public List<QueryVariable> getVariables() {
    return variables;
  }
  
  public void setVariables(List<QueryVariable> variables) {
    this.variables = variables;
  }
}
