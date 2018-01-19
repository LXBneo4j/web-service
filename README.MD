webservice就是远程调用技术,也叫XML Web Service WebService
          是一种可以接收从Internet或者Intranet上的其它系统中传递过来的请求，轻量级的独立的通讯技术。
          是通过SOAP在Web上提供的软件服务，使用WSDL文件进行说明，并通过UDDI进行注册
          
XML:(Extensible Markup Language)扩展型可标记语言。面向短期的临时数据处理、面向万维网络，是Soap的基础。
Soap:(Simple Object Access Protocol)简单对象存取协议。是XML Web Service 的通信协议。当用户通过UDDI找到你的WSDL描述文档后，他通过
     可以SOAP调用你建立的Web服务中的一个或多个操作。SOAP是XML文档形式的调用方法的规范，它可以支持不同的底层接口，像HTTP(S)或者SMTP。
WSDL:(Web Services Description Language) WSDL 文件是一个 XML 文档，用于说明一组 SOAP 消息以及如何交换这些消息。大多数情况下由软件
     自动生成和使用。 
     
创建客户端：
  创建一个client11客户端的项目，然后我们通过Win+R组合键调出cmd,在cmd中输入wsimport -s 我们这个项目的src路径 -keep 我们发布的webservice地址
  

1、百度通用翻译开放平台：