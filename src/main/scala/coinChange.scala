object coinChange {
  //322

  def coinChange(coins: Array[Int], amount: Int): Int = {

    if(amount == 0)
         return 0

    if(coins.contains(amount))
         return 1



    var chk = new Array[Int](amount+1)
    var ret = -1
    val min = coins.min
    if(coins.length == 1 && coins(0) > amount)
      return -1
    coins.foreach(c => {
      if(c < amount)
        chk(c) = 1
    })

    for(i <- min+1 to chk.length-1){
      coins.foreach(c => {
        if(i>c){
          if(chk(i-c) != 0){
            if(chk(i) == 0)
              chk(i) = chk(c)+chk(i-c)
            else
              chk(i) = Math.min(chk(i),(chk(c)+chk(i-c)))
          }
        }
      })
    }

    if(chk(amount) == 0)
      return -1
    chk(amount)
  }

  //it is so~~ slow!!
//  def coinChange(coins: Array[Int], amount: Int): Int = {
//    if(amount == 0)
//      return 0
//
//    if(coins.contains(amount))
//      return 1
//
//    var sortedCoins = coins.sortWith(_ > _)
//    var ret = -1
//
//    sortedCoins.foreach(c => {
//      if(c < amount){
//        val chk = found(sortedCoins,amount-c,1,ret)
//        if(chk != -1)
//          ret = chk
//      }
//    })
//
//    ret
//
//  }
//
//  def found(coins: Array[Int], target: Int, cnt: Int, now: Int) : Int = {
//    if(cnt >= now && now != -1)
//      return -1
//    var ret = -1
//    var chk = now
//    coins.foreach(c => {
//      if(c == target){
//        return cnt+1
//      }else if(c < target){
//        ret = found(coins,target-c,cnt+1,chk)
//        if(ret != -1)
//          chk = ret
//      }
//    })
//
//    ret
//  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](186,419,83,408)
    println(coinChange(tt,6249))
  }
}
