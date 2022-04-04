package com.github.dhananjay12.actions

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBList
import com.intellij.ui.layout.panel
import com.intellij.util.ui.JBUI
import java.awt.Color
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent
import javax.swing.ListSelectionModel

class FindMyInterfaceImplDialog (project : Project, allImpl : List<String>) : DialogWrapper(project, true) {

    private var  mainPanel : DialogPanel? = null
    private var listModel = DefaultComboBoxModel(allImpl.toTypedArray())
    val jbTable: JBList<String>

    init {
        title = "Select One"
        jbTable = JBList(listModel)
        jbTable.autoscrolls = true
        jbTable.border= JBUI.Borders.customLine(Color.BLACK, 1)
        jbTable.selectionMode = ListSelectionModel.SINGLE_SELECTION
        jbTable.selectedIndex = 0
        init()
    }

    override fun createCenterPanel(): JComponent? {
        mainPanel = panel {
            row {
                label("Select")
            }
            row {
                jbTable().focused()
            }
        }

        return mainPanel
    }
}