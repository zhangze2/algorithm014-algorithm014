学习笔记

## 1. 到底用 Integer 还是 int ?

- Integer默认值是null，可以区分未赋值和值为0的情况。比如未参加考试的学生和考试成绩为0的学生
- 加减乘除和比较运算较多，用int
- 容器里推荐用Integer。 对于PO实体类，如果db里int型字段允许null，则属性应定义为Integer。 当然，如果系统限定db里int字段不允许null值，则也可考虑将属性定义为int。

作者：buguge
链接：https://www.jianshu.com/p/ff535284916f


## 2. 思考 ：数组可以有哪些操作？ 

- 按[下标]遍历访问、赋值
- 移动零题目：遇到0，删除 并 添加到数组后；  Java 不适合添加数组



## 3. 为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？

skiplist的操作显然更加局部性一些，锁需要盯住的节点更少，因此在这样的情况下性能好一些