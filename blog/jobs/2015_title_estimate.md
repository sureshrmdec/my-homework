不要揣测公司的意愿了，这篇文章时献给自己的。我做了一件``复杂度``很高的事情和``回报率``很高的事情吗？我这两年浪费了吗？先让我来回顾回顾看下，我收获的什么后，再来评断。我所经历的，以后都是成为我的武器。
解决实际问题的能力（包括了技术和业务能力），然后是技术的深入程度，业绩和贡献、职业态度（软素质）等会作为重要参考。

## 2015工作回顾
2015年的主要工作分3条线来总结，主线是olap的完善、改进和优化；数据仓库作为第二条线；而数据流和其他任务是第三条线。

### olap搭建和优化

- 跟进RTB、ADN两条线业务发展调整完善olap的维度层次模型，设计并实现了人群标签cube，提供单个标签的便捷查询通道。其次拆分原Rtb Hyper cube，缩减数据表大小，提供可靠的（保持查询时间在5min之内）响应服务。增加了Rtb月级别分析cube，支持了使原来基本不能使用的季度数据分析。
- 通过文档、日志和书籍研究mondrian配置使用和数据模型设计。掌握了许多优化方法并运用实践，例如：了解数据立方体对应的关系型数据库模型形式和原理，聚集表的使用技巧；通过独立维度表提升维度筛选90%的速度；数据表的在infobright下的合理大小和保证在分钟级别出结果的承载极限等。
- 加大了数据质量检测，开发数据质量异常检查，实现分交易所实时数据和saiku数据核对。
- 快速学习mondrian源码，修改部分功能以支持现有的大数据查询
	+ 修改筛选大维度列表机制，加入真正的模糊筛选功能。使搜索速度从原来的120s提升到了5s。
	+ 修改过滤栏的限制机制，使原来的在数据主表记录条数达到3亿条（当和维度表join后，形成的表条数将达到上千亿的级别）的情况下，时间查询范围从一周上升到一个月（查询时间限制在5min）。
	+ 扩展了mondrian的spi接口并且开发vertica dialect。解决了vertica与标准sql的差异兼容，特别是一些函数上的兼容问题。
	+ ``修改mondrian的rolap整体结构，从平凡的fact和dimension直接做join在过滤，改成先过滤再join过程，查询效率提升了80%。``
	
- mondrian 搭建和使用
	+ olap原理学习
	+ schema的配置实践
	
### infobright和vertica探究
- 基础使用和性能调查
- 线下实验测试
- 上线部署和修正

从infobright走到vertica，对于一个数据仓库设施调查的基本过程有了一个全面的了解：1.梳理清楚要解决的问题，确定新的软件是否满足这些需求。2.搭建、测试、试用。3.投入使用。4.改进和优化。5.确定使用过程逐渐凸显出的问题是否不能解决，或者解决成本太高？如果是跳回1，开始寻找新软件。
经过对infobright的整个过程，锻炼了

### 数据流事务处理
- 协同组织了Anti过滤环节进入Rtb数据流处理流程中
- 支持BI和运营季度、年度数据导出，从中学习到了提高了自己的数据敏感度，增加了自己对数据模型设计的把握，明白数据设计是从源头产生（UI）就需要开始，而不仅仅是后期收集展示而已。以此推动了iventory维度的编号设计。
话说还是比较支持用数据说话，我猜中几个方向，然后投放使用后，用数据说话，这个方向是对的还是错的。不太喜欢现在公司这种全凭个人经验拍板的方式。

### RTB业务迁移组织

从这次RTB业务迁移任务第一全面深度的了解了RTB的整条线的设计架构，第二也是最重要的是怎么跟进和推进进度。下面列出几主要克服的重要难点：

1. 也许我们都以为事情只要说一遍就行，但是实践发现这样根本行不通。信息不是快速的被各种邮件、qq留言刷掉，就是相关人看见了但是他们故意或者无意忽略，特别是当你在跟进``一项主线外即分支``的工作 。
> 任务被轻易刷掉是因为我们并没有一个统一的协同任务发布系统。所以解决方法就是当面沟通，明确告诉对方确定事情的优先级别和截止时间要求。到对方承诺时间，需要追踪进展，如果过期，需要重新预约截止时间，反复进行。其次还有备案任务总蓝图和进展报告以方便查看。

2. 如何协同，RTB这次迁移的一大挑战就是需要各个线上的人进行协同。
> 这部分通过确认各个部分的先后顺序，关键点的时间保证的梳理，分解成各个小的独立部分，然后找各个线把任务部署下去。

3. 如何制定预案
> 制定预案的前提条件需要了解整个系统的结构。特别是系统的关键点，还有如果应对突发情况。


## 个人提升与成就
### 技术方面：
通过研究mondrian的源码，学习了java编程的方方面面，从设计模型到多线程、线程池等的使用。还有olap的专业知识提升，从mdx的层次设计和如何解析为sql的过程。
vertica、infobright等面相数据分析的数据引擎的了解和使用大大提高对列式数据库基本原理和sql优化方向的理解。综合对spark、hive等数据的了解，区分出各种数据引擎的适合范围和优缺点。
### 沟通和职业素养方面：
通过RTB业务迁移任务，第一次大规模的段时间内频繁和跨部门的同事协作。从中深刻的意识到什么才叫有效的沟通——真正能产生实际工作行动的沟通才叫有效沟通。还有沟通并非想象的一次就成，也许需要反复的进行，形成一种系统的监督模型（只运用在这种短、频、快的任务中）。

## 对复杂系统的思考
## 对沟通的一些思考
大家谈到沟通，想到的都是一个对对或者一群群的人们在欢乐、紧张的滔滔不绝的交谈着。但是真的这就是沟通能力强的表现吗？也许，至少这样做到沟通，沟通无论如何也不可能心里想着对方不用说也明白的方式“心领神会”到。
做到了量保，接下来就轮到质保了。
## 对大数据方向的一些思考
《精通hadoop》上面提到说各种算法在数据大到一定量后，效果是差不多的。所以目前阶段来说数据的收集处理的意义也许远远大于算法设计。所以我选在了数据收集和存储的方向。