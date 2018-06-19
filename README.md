Zipkin集成示例

OpenZipkin的Docker启动方式：docker run -d -p 9411:9411 openzipkin/zipkin

DemoA：使用spring-cloud-sleuth，支持zipkin的扩展brave实现

DemoB：使用brave官方示例实现

Jeager也兼容zipkin数据

docker启动：docker run -d -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p5775:5775/udp -p6831:6831/udp -p6832:6832/udp   -p5778:5778 -p16686:16686 -p14268:14268 -p9411:9411 jaegertracing/all-in-one:latest

Jeager UI访问地址：http://192.168.20.186:16686