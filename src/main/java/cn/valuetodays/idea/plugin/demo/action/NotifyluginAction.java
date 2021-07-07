package cn.valuetodays.idea.plugin.demo.action;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;

public class NotifyluginAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        NotificationGroup group = new NotificationGroup("aaa", NotificationDisplayType.BALLOON, true);
        Notification notification = group.createNotification("我是一条提醒消息", MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
