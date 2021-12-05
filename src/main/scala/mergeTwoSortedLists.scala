//21
object mergeTwoSortedLists {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
       var next: ListNode = _next
       var x: Int = _x
     }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var ret = new ListNode()
    var chk1 = l1
    var chk2 = l2


    if(l1 == null && l2 == null)
      ret
    else if(chk1 == null){
      ret.x = chk2.x
      chk2 = chk2.next
    }else if(chk2 == null){
      ret.x = chk1.x
      chk1 = chk1.next
    }else{
      if(chk1.x <= chk2.x){
        ret.x = chk1.x
        chk1 = chk1.next
      }else{
        ret.x = chk2.x
        chk2 = chk2.next
      }
    }

    var bef:ListNode = ret

    while(chk1 != null && chk2 != null){
      var temp = new ListNode()
      if(chk1.x <= chk2.x){
        temp.x =chk1.x
        chk1 = chk1.next
      }else{
        temp.x =chk2.x
        chk2 = chk2.next
      }

      bef.next = temp
      bef = temp
    }

    if(chk1 == null){
      while(chk2 != null){
        var temp = new ListNode()
        temp.x = chk2.x
        chk2 = chk2.next
        bef.next = temp
        bef = temp
      }
    }else if(chk2 == null){
      while(chk1 != null){
        var temp = new ListNode()
        temp.x =chk1.x
        chk1 = chk1.next
        bef.next = temp
        bef = temp
      }
    }

    ret
  }

  def main(args: Array[String]): Unit = {
    var l1 = null
    var l2 = new ListNode(1,new ListNode(3,new ListNode(4)))

    var tt = mergeTwoLists(l1,l2)
    println(tt)
  }

}
