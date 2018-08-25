package combineByKey

/**
  * TODO
  *
  * @author Patrick.ho
  *
  */
class Fruit(val kind: String, val weight: Int) extends Serializable{
    def makeJuice: Juice = new Juice(weight * 100)
}
