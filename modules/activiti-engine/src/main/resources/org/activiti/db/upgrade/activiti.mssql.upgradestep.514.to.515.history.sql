alter table ACT_HI_TASKINST
    add CATEGORY_ nvarchar(255);
    
drop index ACT_HI_PROCINST.ACT_UNIQ_HI_BUS_KEY;    

alter table ACT_HI_VARINST
    add CREATE_TIME_ datetime; 
    
alter table ACT_HI_VARINST
    add LAST_UPDATED_TIME_ datetime; 
    