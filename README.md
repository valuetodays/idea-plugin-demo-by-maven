# 使用maven开发idea插件（官方都没有提供，自行摸索出来的）

## 为什么非得使用maven？

官方提供的PluginDev方式有两种，第一种是使用DevKit，﻿不支持自动打包；第二种是使用Gradle（Gradle和idea的版本兼容性不好）。

## 原理

1. 将maven工程打包成一个zip，再在idea插件中心进行安装。
2. 使用assembly插件打包成zip
3. 使用ant-run插件来复制插件相关文件到sandbox目录
4. 并启动调试

## 涉及的maven插件

- maven-compiler-plugin （编译源代码）
- maven-assembly-plugin （打包工程）
- maven-antrun-plugin （执行ant任务）

## 配置步骤

1. 下载本仓库代码（是一个基于maven的工程）
2. 导入到idea中（我使用的是IU-2019.2.4）
3. 配置 Project SDK
ctrl+shift+alt+S --> Project --> Project SDK -> New... --> IntelliJ Platform Plugin SDK
4. 点击菜单的Run -> Edit Configurations...，在Run/Debug Configurations对话框中点击左上角的“+”，下拉找到并选择Plugin，
在Name框中输入demo，JRE选第3步配置的SDK
5. 编辑.idea/workspace.xml，找到`<component name="RunManager">`，修改如下：
  *   `<module name="" />` 修改为 `<module name="idea-plugin-demo-by-maven" />`，即是工程名称
  * `<option name="Make" enabled="true" />`下面添加一行
    `<option name="Maven.BeforeRunTask" enabled="true" file="$PROJECT_DIR$/pom.xml" goal="clean verify -DskipTests" />`
6. 运行，点击菜单的Run -> Run 'demo'或Debug 'demo'都行，启动后会重新打开一个idea。
7. 等新开的idea运行成功后随意打开一个工程或新建一个工程，在Tool菜单下即可看到菜单“测试父菜单”，点击体验一下吧。 

## 调试

文件位置： .idea/workspace.xml

```xml
  <component name="RunManager">
    <configuration name="Unnamed" type="#org.jetbrains.idea.devkit.run.PluginConfigurationType">
      <module name="idea-plugin-demo-by-maven" />
      <option name="VM_PARAMETERS" value="-Xmx512m -Xms256m -ea" />
      <option name="PROGRAM_PARAMETERS" value="" />
      <predefined_log_file enabled="true" id="idea.log" />
      <method v="2">
        <option name="Make" enabled="true" />
        <option name="Maven.BeforeRunTask" enabled="true" file="$PROJECT_DIR$/pom.xml" goal="clean verify -DskipTests" />
      </method>
    </configuration>
  </component>
```

`clean verify -DskipTests`

## 命令行打包

`mvn clean package -DskipTests`


## 其它

- 获取环境变量

## 功能

- [x] 添加一个菜单（一级菜单和二级菜单）
- [x] 添加一个ToolWindow
- [ ] 添加一个Setting项
- [x] 添加一个Icon，Icons的包要和hello.png的包一样且都是icons
- [ ] 可以参考其它插件的实现 （C:\Users\Administrator\.IntelliJIdea2019.2\config\plugins）
- [x] 访问网站

## 引用

- <https://plugins.jetbrains.com/docs/intellij/welcome.html>
- Idea插件开发-开发自己的第一款idea插件 <https://juejin.cn/post/6844904127990857742>
- 你们要的Intellij IDEA 插件开发秘籍，来了！ <https://cloud.tencent.com/developer/article/1348741>
- <https://github.com/AAA-AA/notebook-plugin>
- <https://www.bilibili.com/video/BV1Zi4y1b7fw>

