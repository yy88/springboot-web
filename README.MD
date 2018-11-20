<h2>springboot2开发web项目</h2>
说明：<br>
1、UI使用了bootstrap框架,页面使用了thymeleaf模板引擎，包含了大气的登录界面，背景可以动态变化，登录信息面板透明化处理。<br>
2、使用拦截器进行了安全控制，用户名和密码使用了yml配置为多用户<br>
3、使用了lombok插件方便使用log对象，及getter/setter的自动生成。<br>
4、使用了默认的logback日志框架<br>
5、使用了多环境的yml配置，application-dev.yml,application-prod.yml，灵活部署<br>
6、部署的时候，可以使用springboot默认支持的外部配置方式:config/application-prod.yml<br>