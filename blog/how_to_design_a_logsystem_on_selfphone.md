如何设计一个日志收集处理器
----------------------
我第一次设计统计服务的时候，想都没想就用mysql作为日志的收集存储媒介。没有别的原因，仅仅是因为我一直都在写网站，我周围的也都是写网站的。所以这套最熟悉的，最直接的道路就被我采纳了。

我的这次设计的系统运行了1年，直到我离职后，它也没退休。除了使服务器cpu每天都飙升90%以外，貌似没有多大问题。我现在都是感到很意外，原来对已一个小型纯做app的公司来说，数据收集和分析仅仅就是一张简单的用户列表就行都行，每天就出每日新增数、总用户数、设备类型分布几个大数字就行。意外的简单，可能不是说更复杂的数据挖掘没有必要性，而是根本就没意识还有别的事情，更多的事情可做。这就是眼界的限制，当一群人都逃不出一个圈子时，就会觉得自己做完了应该做的所有事，这是件多么可怕地事情。

后台我跳槽了，决定一定要找一个能发挥数据处理、挖掘的公司。果然我看到了一个新的领域和一些新的方法。

怎么设计日志，处理日志？
