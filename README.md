#Tint变色

##作用
tint是Android系统上用于颜色修改的一个功能，让Android也能有iOS那么方便的图片色调转换，目的是为了减小apk
的大小，比如我们开发中需要用到的点击状态：一般需要两张图，一张常态一张点击态的图（这里指的是带图片的不能
用点9代替的图片），通过tint我们可以用一张图做出多种背景状态

##效果：
![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/demo.gif)

* 原图图片资源
![img](https://github.com/wzgiceman/TintDemo/blob/master/gif/electric.png)

**我们这里只用了这一张图片资源**
继续我们的实现过程

##定义方法
首先我们先封装一个修改tint的方法，用于后边统一的修改
```java
public Drawable tintDrawable(Drawable drawable, ColorStateList color) {
        final Drawable tempDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(tempDrawable, color);
        return tempDrawable;
    }
```
##实现简单tint修改
* [xml定义很简单不贴代码了，需要直接看链接吧](https://github.com/wzgiceman/TintDemo/blob/master/app/src/main/res/layout/activity_main.xml)
![xml](https://github.com/wzgiceman/TintDemo/blob/master/gif/xml.png)



