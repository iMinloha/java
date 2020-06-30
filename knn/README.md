#调用方法

使用小写 "knn" 定义对象就可以

#导入样本

样本采用 Map 类型
                
                k 是 当前样本唯一标识
                
                v 是 样本数据

Map写法举例:
   
    List<Double> list = new ArrayList<>();
    list.add(样本x坐标);
    list.add(样本y坐标)
    list.add(样本z坐标)
    
    HashMap map = new HashMap();
    map.put("样本唯一标识",list);

注意: Map需要使用HashMap，确保数据安全.
    Map.value要使用列表，这是训练数据

传递样本方法:

    knn k = new knn();
    k.getmap();
    
传递样本Map

使用knn对象调用 **getNearList()** 传入待测样本的坐标值

例如:

    k.getNearList(1.2,2.3,3.4);
    
注意，参数为double类型.
     此处为函数重载，可以计算二维坐标，也可以计算二维坐标

#获取值
获取值可以通过 knn 对象调用变量 name 获取最近点的唯一标识
                   调用变量 large 获取到最近点的距离
                   
例:
    
    //获取唯一标识
    String name = k.name;
    //获取最近点距离
    double large = k.large;
    
    
#删除操作
通过knn对象调用rm方法,传递参数唯一标识
    
    k.rm("样本唯一标识");

    
#特别注意
如果出现多维度调用的情况下，一定要注意，
一旦离开出现维度与数据样本不匹配，原样本会被清楚，并且
程序停止运行