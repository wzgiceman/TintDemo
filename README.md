#Tint变色

##作用
tint是Android系统上用于颜色修改的一个功能，让Android也能有iOS那么方便的图片色调转换，目的是为了减小apk
的大小，比如我们开发中需要用到的点击状态：一般需要两张图，一张常态一张点击态的图（这里指的是带图片的不能
用点9代替的图片），通过tint我们可以用一张图做出多种背景状态

##效果：
![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/demo.gif)

* 原图图片资源

  ![img](https://github.com/wzgiceman/TintDemo/blob/master/gif/electric.png)

**我们这里只用了这一张图片资源**开始我们的实现过程

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
* 代码

```java
img1 = (ImageView) findViewById(R.id.img_normal);
img2 = (ImageButton) findViewById(R.id.img_click);

final Drawable originBitmapDrawable = getResources().getDrawable(R.drawable.electric);
img1.setImageDrawable(tintDrawable(originBitmapDrawable, ColorStateList.valueOf(Color.GREEN)))
```
* 效果

  ![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/sample_change.png)

* 你会发现原本第一张原图也跟着一起改了，这是为什么呢？其实是因为tint修改默认是修改原始图片drawable
的颜色，所以如果一张图片在多个地方同时使用，会导致一起被改变的效果，注意：如果多次修改只会保持最后一次
修改的颜色

* 指定修改图片
但是使用时，我们通常是需要指定控件被修改的，这样我们需要用到Drawable的`mutate()`方法，修改上面的代码

```java
img1 = (ImageView) findViewById(R.id.img_normal);
img2 = (ImageButton) findViewById(R.id.img_click);

final Drawable originBitmapDrawable = getResources().getDrawable(R.drawable.electric).mutate();
img1.setImageDrawable(tintDrawable(originBitmapDrawable, ColorStateList.valueOf(Color.GREEN)))
```
问题解决了：

![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/demo.png)

##多状态tint修改方案
实际使用中我们通常需要给一个控件设置多个状态，比如返回按钮这样的功能，同样我们的tint也具有这样的能力

* 创建资源color文件

  ![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/FC69.tmp.png)
* 创建一个select文件`select_click`

```java
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="#1d16a4" android:state_pressed="true"/>
    <item android:color="#f20934" android:state_pressed="false"/>
</selector>
```
* 代码中调用

```java
 final Drawable originBitmapDrawable2 = getResources().getDrawable(R.drawable.electric).mutate();
 img2.setImageDrawable(tintDrawable(originBitmapDrawable2, getResources().getColorStateList(R.color.select_click)));

```
* 效果：

![demo](https://github.com/wzgiceman/TintDemo/blob/master/gif/demo.gif)
