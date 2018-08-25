package combineByKey

/**
  * TODO
  *
  * @author Patrick.ho
  *
  */
class Juice(val volumn: Int) extends Serializable{
    def add(j: Juice): Juice = new Juice(volumn + j.volumn)
}
