package cn.valuetodays.idea.plugin.demo.action;

import com.intellij.ide.browsers.BrowserLauncherImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.net.URI;

/**
 * @author lei.liu
 * @since 2021-07-06 16:29
 */
public class VisitOfficialWebAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        BrowserLauncherImpl.getInstance().browse(URI.create("http://eblog.valuetodays.cn/"));
    }
}
