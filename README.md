## @OneToMany

## @ManyToOne

## 多对一单向外键

- 多方持有一方的引用，比如：多个学生对应一个班级（多对一）

- 多方需要添加如下注解：

  ~~~java
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  // referencedColumnName 关联类（表）在数据库中的关联字段名
  // name 本类（表）在数据库的字段名   
  @JoinColumn(name = "classe_id", referencedColumnName = "id" )
  ~~~


## 一对多单向外键

- 一方持有多方的集合，比如：一个班级有多个学生（一对多）

- https://www.jianshu.com/p/0a2163273b3e

- 一方需要添加的注解

  ~~~java
      @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
      @JoinColumn(name = "classe_id")
  ~~~

### 多对一的时候，多方设置EAGER,一方设置LAZY

- 多方持一方的引用

- 多方需要添加如下注解：

  ```java
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  // referencedColumnName 关联类（表）在数据库中的关联字段名
  // name 本类（表）在数据库的字段名   
  @JoinColumn(name = "classe_id", referencedColumnName = "id" )
  ```

- 一方持有多方的集合

- 一方需要添加的注解

  ```java
      @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
      @JoinColumn(name = "classe_id")
  ```

- 注意
       - @OneToMany 可以即可以设置@JoinColumn 也可以设置 mappedBy
       - @JoinColumn ： 此时可以多和一的一方都能级联操作数据，每次执行都会有update操作
       - mappedBy： 此时指定多的一方为被维护方，只能通过一的一方级联（主控方）更新

## 一对一单向外键

- 要添加的注解

~~~
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parents_id",unique = true)
~~~



- 注意： 保存时，应该先保存外键对象，再保存主表对象

## 一对一双向外键

- 维护端(主控方)

  ~~~
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parents_id", referencedColumnName = "id" ,unique = true)
  ~~~

- 被维护端

  ~~~
  @OneToOne(mappedBy = "parents")
  ~~~

- mappedBy

  表明被维护端

## 多对多单向外键

- 学生和老师构成多对多的关联关系

- 其中一个多方持有另一个多方的集合对象（学生持有教师的集合）

- 创建中间表

  ~~~shell
   //cascade = CascadeType.ALL 在保存数据时候 如果不先手动持久化被维护端的数据 会发生下面的异常
     @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable(
              // 中间表名称
              name = "students_teachers",
              // 学生表的外键
              joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
              // 老师表的外键
              inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")}
      )
  ~~~

  - 异常

    ~~~
    Exception in thread "main" org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.mao.Address
    ~~~

    导致原因：

    你的对象引用了一个未保存的瞬态实例，换句话讲就是：因为主表的记录不曾插入，所以参照该记录的从表记录也就无法插入

    解决方案：

    1：通过cascade=CascadeType.All将Hibernate的所有持久化操作都级联到关联实体

    2：将你需要插入的数据先持久化，再映射到相应的表中。

































