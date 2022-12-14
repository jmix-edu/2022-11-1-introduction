package com.company.tm.security;

import com.company.tm.entity.Project;
import com.company.tm.entity.Subtask;
import com.company.tm.entity.Task;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "TaskCreator", code = "task-creator")
public interface TaskCreatorRole {
    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE})
    void task();

    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.READ)
    void project();

    @EntityAttributePolicy(entityClass = Subtask.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Subtask.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void subtask();

    @MenuPolicy(menuIds = "tm_Task.browse")
    @ScreenPolicy(screenIds = {"tm_Task.browse", "tm_Task.edit", "tm_Project.browse", "tm_Subtask.edit"})
    void screens();
}