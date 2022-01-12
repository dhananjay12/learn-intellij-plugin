package com.github.dhananjay12.learnintellijplugin.services

import com.intellij.openapi.project.Project
import com.github.dhananjay12.learnintellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
