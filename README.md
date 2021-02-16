# Maven-Aggregation-Project

### 编写环境

本项目使用 SSM 框架来编写实现，具体编写环境如下：

- IDE：IDEA 2019.03；
- 数据库：MySQL 5.5.62

### 项目功能

使用 SSM 框架实现的 web 项目，支持用户从页面录入信息，然后把信息存入数据库这一操作。不过与传统的简单的使用包分类来划分代码层次不同的是，此聚合工程使用子模块来划分层次并相互依赖与调用。

### 项目结构

<img src="https://gitee.com/eric0228/pic-go-images/raw/master/img/image-20210216105100185.png" alt="maven聚合项目结构" style="zoom:80%;" />

### 层次调用图

<img src="https://gitee.com/eric0228/pic-go-images/raw/master/img/20201223maven_manager调用层次结构图.png" alt="20201223maven_manager调用层次结构图" style="zoom:80%;" />

`manager-pojo` 作为提供管理实体信息的子模块；

`manager-dao` 作为提供数据访问层功能的子模块；

`manager-service` 作为处理业务逻辑功能的子模块；

`manager-web` 作为提供控制层与前端页面的子模块。

这些模块由聚合工程 `manager` 统一管理。

### 数据库

项目所使用的数据库为MySQL，此项目的着重点还是在理解Maven聚合工程的层次与结构，为了方便测试，数据库及项目所提供的功能都相对简单。

所使用的数据库表结构如下：

| 字段名 | 中文含义 | 类型        | 约束     | 备注       |
| ------ | -------- | ----------- | -------- | ---------- |
| id     | 姓名     | int         | 主键     | 自增长     |
| name   | 姓名     | varchar(30) | not null |            |
| gender | 性别     | varchar(5)  | not null | ‘男’或‘女’ |
| birth  | 出生日期 | date        | not null |            |

创建表语句：

```mysql
CREATE TABLE user
(    id int PRIMARY KEY AUTO_INCREMENT,
     name varchar(30) NOT NULL,
     gender varchar(5) NOT NULL,
     birth date NOT　NULL
);

ALTER TABLE user　ADD CONSTRAINT ck_user_gender CHECK(gender='男' or gender='女');
```

### 项目运行

1. 使用 Git 命令将项目克隆至本地：

   ```
   https://github.com/CoderGeshu/Maven-Aggregation-Project.git
   ```

2. 使用本地 IDE 导入此 `manager` 项目；

3. 修改项目 maven 仓库地址（设置成自己本地的）；

4. 创建数据库：

   ```mysql
   CREATE DATABASE maven_manager;
   ```

   使用上述创建表命令创建表结构，并修改 `src/main/resources/resource/jdbc.properties` 中的属性配置于本地一致。

5. 因为在 `manager-web` 子模块中配置了 tomcat 插件，所以是可以使用此插件来进行运行 web 项目的，但是在运行之前，需要把每个子模块进行打包，这里借助 IDEA 自带的界面操作方式，如下：

   <img src="https://gitee.com/eric0228/pic-go-images/raw/master/img/image-20210216111029953.png" alt="Maven聚合项目打包" style="zoom:80%;" />

   然后点击执行 manager 中 Lifecycle 下的 install，就会把整个项目包括子模块进行安装，安装成功后会在控制台显示 `BUILD SUCCESS` 信息。

   最后使用 manager-web 模块下的 tomcat 插件，点击 run 命令，使容器运行起来：

   <img src="https://gitee.com/eric0228/pic-go-images/raw/master/img/image-20210216111230163.png" alt="Maven聚合项目运行tomcat" style="zoom:80%;" />

6. tomcat 容器运行成功以后，使用浏览器访问 `localhost:9090/addUser` 路径（因为我们在配置 tomcat 的时候把其访问端口配置为了 9090），即可进入功能页面，之后在 Web 页面录入用户信息提交后会自动添加至我们的数据库中（演示略）。

   