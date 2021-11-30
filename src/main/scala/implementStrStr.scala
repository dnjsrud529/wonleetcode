object implementStrStr {
  def strStr(haystack: String, needle: String): Int = {
    var ret = -1
    if(haystack.length == 0 && needle.length == 0)
      return 0
    else{
      ret = haystack.indexOf(needle)
    }
    ret
  }

}
