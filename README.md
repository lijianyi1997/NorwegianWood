# NorwegianWood
代码在master分支中。这是一个【新手开发练习用】介绍小说《挪威的森林》的APP，它实现的功能很简单，没有任何消息传递。其中使用到了ListView/RecyclerView和基本布局来实现页面，是看完《第一行代码》前三章就可以实现的APP~不过其中实现了屏幕适配和自定义状态栏/ActionBar这类细致的地方。

## 页面介绍
这款APP有五个页面，分别是主页、内容梗概页、同名电影介绍页、演员表页以及剧照展示页。里面所有的文字内容是从百度复制粘贴的，不是原创，主要是看APP的结构。

（上传的图片太大了，就不在这里放了，可以在readme_img文件夹中查看==）

## 屏幕适配
使用了今日头条的AdroidAutoSize，非常简单好用（https://github.com/JessYanCoding/AndroidAutoSize）

## 某些自定义设置

1、使用theme.xml设置ActionBar的背景色，也可以添加其他自定义设置；


2、使用StatusBarCompat设置状态栏颜色，这个很好用~
通过增加一行代码直接引入项目即可。

```java
implementation 'com.githang:status-bar-compat:latest.integration'
```


3、修改对话框中按钮样式：
通过在.java中获得button后set的方式可以自定义按钮的背景色及文字颜色。

