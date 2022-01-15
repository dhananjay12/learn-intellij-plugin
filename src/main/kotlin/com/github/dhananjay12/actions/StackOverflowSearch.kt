package com.github.dhananjay12.actions

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.util.IconLoader
import com.intellij.util.io.URLUtil

class StackOverflowSearch : AnAction(IconLoader.getIcon("/icons/stackoverflow.png",StackOverflowSearch::class.java)) {

    override fun actionPerformed(e: AnActionEvent) {
        val ediTorRequiredData = e.getRequiredData(CommonDataKeys.EDITOR)
        val caretModel = ediTorRequiredData.caretModel
        val selectedText = caretModel.currentCaret.selectedText

        val searchQuery = "https://stackoverflow.com/search?q=%s"

        val searchBy = String.format(
                searchQuery, URLUtil.encodeURIComponent(
                selectedText!!
        )
        )
        BrowserUtil.browse(searchBy)
    }
}