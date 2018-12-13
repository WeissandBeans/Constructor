package view;

import model.Project;

/**
 * An abstract class for Controllers that contain Projects.
 * @author Samantha
 */
abstract class ProjectBasedController {
	Project project;

	protected Project getProject() {
		return project;
	}

	protected void setProject(Project project) {
		this.project = project;
	}

}
