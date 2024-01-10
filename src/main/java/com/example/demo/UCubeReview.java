package com.example.demo;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang3.ObjectUtils;

public class UCubeReview extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project currentProject = event.getProject();

        DataContext dataContext = event.getDataContext();
        Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        if (editor != null) {
            SelectionModel selectionModel = editor.getSelectionModel();

            if (ObjectUtils.isEmpty(selectionModel.getSelectedText())) {
                Messages.showMessageDialog(currentProject, null, "리뷰할 블dh록을 지정해주세요." , Messages.getInformationIcon());
                return;
            }

            String selectedText = selectionModel.getSelectedText();
            selectedText = selectedText.trim();
            if (selectedText.startsWith("\"")) {
                selectedText = selectedText.substring(0,1);
            }
            try {
                // FIXME

                Messages.showMessageDialog(currentProject, selectedText, "리뷰 결과", Messages.getInformationIcon());
                Messages.showMessageDialog(currentProject, "asd", "리뷰 asd", Messages.getInformationIcon());
            } catch ( Exception t) {
                Messages.showMessageDialog(currentProject, selectedText + System.lineSeparator()+ t.getMessage(), "에러가 발생했습니다." , Messages.getInformationIcon());
            }
        }
    }
}
