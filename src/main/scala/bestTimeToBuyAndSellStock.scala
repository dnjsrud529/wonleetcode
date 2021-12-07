object bestTimeToBuyAndSellStock {
  //121
  /*def maxProfit(prices: Array[Int]): Int = {
    var ret = 0
    var max = prices.sortWith(_>_)(0)
    if(prices.size == 0)
      return ret

    prices.zipWithIndex.foreach {
      case (num, i) => {
        var chk = num
        if(num == max){
          if(prices.slice(i+1,prices.length).length != 0)
            max = prices.slice(i+1,prices.length).sortWith(_>_)(0)
        }
        if(ret < max - num)
          ret = max - num
      }
    }
    ret
  }*/

  def maxProfit(prices: Array[Int]): Int = {
    var max = 0
    var chk = prices(0)
    if(prices.size == 0)
      return max

    prices.foreach(pri => {
      if(chk > pri)
        chk = pri

      if(max < pri - chk)
        max = pri - chk
    })
    max
  }
  def main(args: Array[String]): Unit = {
    var tt = Array[Int](1,2)
    println(maxProfit(tt))
  }

}
