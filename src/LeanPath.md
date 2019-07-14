- 第 1 章说明一个 HTTP 服务器是如何工作的，第 2 章突出介绍了一个简单的 servlet 容器。
接下来的两章关注连接器，第 5 章到第 20 章涵盖容器里边的每一个组件。以下是各章节的摘要。
注意:对于每个章节，会有一个附带程序，类似于正在被解释的组件。

- 第 1 章从这本书一开始就介绍了一个简单的 HTTP 服务器。要建立一个可工作的 HTTP服务器，
你需要知道在 java.net 包里边的 2 个类的内部运作：Socket 和 ServerSocket。这里有关于这 2
个类足够的背景资料，使得你能够理解附带程序是如何工作的。
- 第 2 章说明简单的 servlet 容器是如何工作的。这一章带有 2 个 servlet 容器应用，可以处
理静态资源和简单的 servlet 请求。尤其是你将会学到如何创建 request 和 response 对象，然
后把它们传递给被请求的 servlet 的 service 方法。在 servlet 容器里边还有一个 servlet，你
可以从一个 web 浏览器中调用它。
- 第 3 章介绍了一个简化版本的 Tomcat 4 默认连接器。这章里边的程序提供了一个学习工具，
用于理解第 4 章里边的讨论的连接器。
- 第 4 章介绍了 Tomcat 4 的默认连接器。这个连接器已经不推荐使用，推荐使用一个更快的
连接器，Coyote。不过，默认的连接器更简单，更易于理解。
- 第 5 章讨论 container 模块。container 指的是 org.apache.catalina.Container 接口，有
4 种类型的 container:engine, host, context 和 wrapper。这章提供了两个工作于 context 和
wrapper 的程序。
- 第 6 章解释了 Lifecycle 接口。这个接口定义了一个 Catalina 组件的生命周期，并提供了
一个优雅的方式，用来把在该组件发生的事件通知其他组件。另外，Lifecycle 接口提供了一个
优雅的机制，用于在 Catalina 通过单一的 start/stop 来启动和停止组件
- 第 7 章包括日志，该组件是用来记录错误信息和其他信息的。
- 第 8 章解释了加载器(loader)。加载器是一个重要的 Catalina 模块，负责加载 servlet 和
一个 web 应用所需的其他类。这章还展示了如何实现应用的重新加载。
- 第 9 章讨论了管理器(manager)。这个组件用来管理会话管理中的会话信息。它解释了各式
各样类型的管理器，管理器是如何把会话对象持久化的。在章末，你将会学到如何创建一个的应
用，该应用使用 StandardManager 实例来运行一个使用会话对象进行储值的 servlet。
- 第 10 章包括 web 应用程序安全性的限制，用来限制进入某些内容。你将会学习与安全相关
的实体，例如
主角(principals)，角色(roles)，登陆配置，认证等等。你也将会写两个程序，它们在
StandardContext 对象中安装一个身份验证阀(authenticator valve)并且使用了基本的认证来
对用户进行认证。
- 第 11 章 详 细 解 释 了 在 一 个 web 应 用 中 代 表 一 个 servlet 的
org.apache.catalina.core.StandardWrapper 类。特别的是，这章解释了过滤器(filter)和一
个 servlet 的 service 方法是怎样给调用的。这章的附带程序使用 StandardWrapper 实例来代表
servlet。
- 第 12 章 包 括 了 在 一 个 web 应 用 中 代 表 一 个 servlet 的
org.apache.catalina.core.StandardContext 类。特别是这章讨论了一个 StandardContext 对
象是如何给配置的，对于每个传入的 HTTP 请求在它里面会发生什么，是怎样支持自动重新加载
的，还有就是，在一个在其相关的组件中执行定期任务的线程中，Tomcat 5 是如何共享的。
- 第 13 章介绍了另外两个容器：host 和 engine。你也同样可以找到这两个容器的标准实
现:org.apache.catalina.core.StandardHost 和 org.apache.catalina.core.StandardEngine。
- 第 14 章提供了服务器和服务组件的部分。服务器为整个 servlet 容器提供了一个优雅的启
动和停止机制，而服务为容器和一个或多个连接器提供了一个支架。这章附带的程序说明了如何
使用服务器和服务。
- 第 15 章解释了通过 Digester 来配置 web 应用。Digester 是来源于 Apache 软件基金会的一
个令人振奋的开源项目。对那些尚未初步了解的人，这章通过一节略微介绍了 Digester 库以及
XML 文件中如何使用它来把节点转换为 Java 对象。然后解释了用来配置一个 StandardContext
实例的 ContextConfig 对象。
- 第 16 章解释了 shutdown 钩子，Tomcat 使用它总能获得一个机会用于 clean-up，而无论用
户是怎样停止它的(即适当的发送一个 shutdown 命令或者不适当的简单关闭控制台)。
- 第 17 章讨论了通过批处理文件和 shell 脚本对 Tomcat 进行启动和停止。
- 第 18 章介绍了部署工具(deployer)，这个组件是负责部署和安装 web 应用的。
- 第 19 章讨论了一个特殊的接口，ContainerServlet，能够让 servlet 访问 Catalina 的内部
对象。特别是，它讨论了 Manager 应用，你可以通过它来部署应用程序。
- 第 20 章讨论了 JMX 以及 Tomcat 是如何通过为其内部对象创建 MBeans 使得这些对象可管理
的。