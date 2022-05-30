/*
## hashmap源码分析
知识点：
    1). hash底层是数组+链表的数据结构(1.7), 哈希表
        hash底层是数组+链表+红黑树的数据结构(1.8)
		为什么要调整成数组+链表+红黑树：
		    主要是为了提升在hash严重冲突时(链表过长)的查找性能，链表的查找性能是 O(n)，而使用红黑树是 O(logn)
		什么时候用链表？什么时候用红黑树
			对于增加：
				 当链表节点大于8并且数组长度大于等于64时，触发链表节点转红黑树节点（treeifyBin）(单向链表->双向链表->红黑树)
				 如果数组长度小于64，则不会触发链表转红黑树，会进行扩容（resize）
			对于移除：
				 当同一个索引位置上的节点在移除后达到6个时，并且该索引位置的节点是红黑树，
				 会触发红黑树节点转成链表
		
		伪代码：
		    // 树形阈值 为什么要定义成8？ 主要是基于时间和空间上权衡的结果，节点太少红黑树查找性能并不明显
            static final int TREEIFY_THRESHOLD = 8;
			// 底层主数组的最小容量
			static final int MIN_TREEIFY_CAPACITY = 64;
		    // 移除红黑树的阈值
			// 为什么转回链表的阈值要设为6？ 少于8个时就切换成链表，当节点在8个徘徊时，频繁成功切换，会造成新能损耗
			static final int UNTREEIFY_THRESHOLD = 6;
            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                   treeifyBin(tab, hash);

			if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
			      resize();   // 扩容
    2).构造方法：
      1.7 调用构造方法时已初始化底层主数组大小
      1.8 采用的懒加载模式，第一次put()时开辟主数组空间
	  hashmap中的重要属性：
	     // 主数据数组的大小默认为16，默认初始容量-必须是2的幂
	     static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 左移4位
	     transient int size; // 已经存在的节点数据个数
	     transient Node<K,V>[] table;// 底层的Node[] 主数据数组
		 // 记录hashmap在结构上被修改的次数 使用迭代器获取数据时 
		    字段值发生变化会发生并发修改异常(ConcurrentModificationException)
	     transient int modCount;
		 // 扩容阈值(容量*负载因子)：当hashmap中的个数达到该值 触发扩容
		 int threshold;// 还有一个作用 初始化容量
		 // 默认负载因子
		 // 为什么设计成0.75？ 从空间利用率及查询时间上的权衡结果，如果设计成1,那么空间利用率好
		                       但发生hash冲突的概率大，查找时间会增大，设计成0.5，那么空间利用率不高，造成资源损耗
		 static final float DEFAULT_LOAD_FACTOR = 0.75f;
		 // 负载因子 未手动指定时等于DEFAULT_LOAD_FACTOR
		 final float loadFactor;
		 static final int TREEIFY_THRESHOLD = 8; // 上面有介绍
		 static final int UNTREEIFY_THRESHOLD = 6;// 上面有介绍
		 
      public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
      }
	  
      public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
      }  
	  
	  public HashMap(int initialCapacity, float loadFactor) {
		.....
		this.loadFactor = loadFactor;
		// tableSizeFor() 计算我们传入的容量大于等于该容量的最小2的N次方(不为2的N次方时 hash冲突的概率会大)
		this.threshold = tableSizeFor(initialCapacity);
      }
    3.HashMap插入流程
	
	4.HashMap扩容流程
	
    5.HashMap相关面试题
	  1).hashmap不是线程安全的：体现在hashmap在并发下存在数据覆盖，遍历数据时还会出现并发修改异常，
	     1.7采用的是头插法，会导致同一索引位置的节点扩容时顺序反掉(环形链表)
		 1.8采用的是尾插法，顺序不会反掉，不存在死循环
      2).		 
	



*/

//保证并发访问时，若HashMap内部结构发生变化，快速响应失败