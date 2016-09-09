package org.activiti.engine.test.api.repository;

import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;

public class ModelQueryEscapeClauseTest extends PluggableActivitiTestCase {

  private String modelOneId;
  
  private String modelTwoId;
  
  @Override
  protected void setUp() throws Exception {
    Model model = repositoryService.newModel();
    model.setTenantId("mytenant%");
    model.setName("my model%");
    model.setKey("someKey1");
    model.setCategory("test%");
    repositoryService.saveModel(model);
    modelOneId = model.getId();
    
    model = repositoryService.newModel();
    model.setTenantId("mytenant_");
    model.setName("my model_");
    model.setKey("someKey2");
    model.setCategory("test_");
    repositoryService.saveModel(model);
    modelTwoId = model.getId();
    
    repositoryService.addModelEditorSource(modelOneId, "bytes".getBytes("utf-8"));
    repositoryService.addModelEditorSource(modelTwoId, "bytes".getBytes("utf-8"));
    
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    repositoryService.deleteModel(modelOneId);
    repositoryService.deleteModel(modelTwoId);
  }
  
  public void testQueryByNameLike() throws Exception {
    ModelQuery query = repositoryService.createModelQuery().modelNameLike("%\\%%");
    Model model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey1", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
    
    query = repositoryService.createModelQuery().modelNameLike("%\\_%");
    model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey2", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
  }
  
  public void testQueryByCategoryLike() throws Exception {
    ModelQuery query = repositoryService.createModelQuery().modelCategoryLike("%\\%%");
    Model model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey1", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
    
    query = repositoryService.createModelQuery().modelCategoryLike("%\\_%");
    model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey2", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
  }

  public void testQueryByTenantIdLike() throws Exception {
    ModelQuery query = repositoryService.createModelQuery().modelTenantIdLike("%\\%%");
    Model model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey1", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
    
    query = repositoryService.createModelQuery().modelTenantIdLike("%\\_%");
    model = query.singleResult();
    assertNotNull(model);
    assertEquals("someKey2", model.getKey());
    assertEquals("bytes", new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
    assertEquals(1, query.list().size());
    assertEquals(1, query.count());
  }
}
