package com.nokia.example.Interview;

public class GitAndSvnIssue {

    /**
     * GIT与SVN的区别：
     *      1、git是分布式的，但是svn不是：
     *          git与svn一样有自己的集中式版本库或服务器，但是git更倾向于被使用与分布式，从中心版本库或服务器
     *          上check out代码后会在自己的电脑上克隆一个自己的版本库
     *
     *          svn只能有一个中央版本库，但是git可以有无数个
     *
     *      2、git把内容按元数据方式存储，而svn是按文件存储：
     *
     *      3、git的分支与svn的分支不同：
     *          svn的分支是在另外一个目录，但是git的分支可以在一个目录创建多个分支，svn合并分支很麻烦而且经常可能
     *          漏掉分支，但是git合并分支非常简单，而且不容易漏掉分支
     *      4、git没有一个全局的版本号，但是svn有
     *      5、git内容的完整性要优于svn
     *      6、svn必须要先update然后再commit，经常忘记合并时就会出一些错误，但是git很少出现这种情况
     *
     *
     */

}
