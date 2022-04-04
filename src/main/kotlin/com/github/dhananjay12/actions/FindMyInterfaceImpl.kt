package com.github.dhananjay12.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ClassInheritorsSearch

class FindMyInterfaceImpl: DumbAwareAction() {

    val fullClassName = "com.example.openapi.api.PetsApi";
    // "com.example.samplejar.MyInterface"
    // "org.springframework.boot.context.event.SpringApplicationEvent"
    // "com.example.openapi.api.PetsApi"

    override fun actionPerformed(e: AnActionEvent) {
        val myClass = JavaPsiFacade.getInstance(e.project!!).findClass(
            fullClassName,
            GlobalSearchScope.allScope(e.project!!)
        )

        fun getEntireName(psiClass: PsiClass): String {
            val packageName = (psiClass.containingFile as PsiJavaFile).packageName
            return "$packageName.${psiClass.name}"
        }

        val events = ClassInheritorsSearch.search(
            myClass!!, GlobalSearchScope.allScope(e.project!!),
            true, true, true
        )
            .map { getEntireName(it) }.toList()

        val dialog = FindMyInterfaceImplDialog(e.project!!, events)

        dialog.show()

        if (dialog.exitCode === DialogWrapper.CANCEL_EXIT_CODE) {
            return
        }

    }

    override fun update(e: AnActionEvent) {
        //super.update(e)
        val myClass = JavaPsiFacade.getInstance(e.project!!).findClass(
            fullClassName,
            GlobalSearchScope.allScope(e.project!!)
        )

        if (myClass == null) {
            e.presentation.isVisible = false
            return
        }

        val allImpl = ClassInheritorsSearch.search(
            myClass, GlobalSearchScope.allScope(e.project!!),
            true, true, true
        )

        if (!allImpl.any()) {
            e.presentation.isVisible = false
            return
        }

    }
}