# timeserver-api

## 简介
基于spring cloud 的openfeign,实现对接口的feign支持

## 重要提示
** 在定义接口时,不能在整个类上注解@RequestMapping,否则fallback对应的实现类会被作为spring mvc的实现类引入,同一个url对应多个实现,整个程序无法正常工作 **
