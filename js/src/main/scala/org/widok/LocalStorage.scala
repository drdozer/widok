package org.widok

import org.scalajs.dom._
import scala.collection.immutable.HashMap

case class SaveMany(kvp: HashMap[String, String])

/**
 * wrapper around window.localStorage provides some additional methods.
 */
object LocalStorage {

  private val storage = window.localStorage

  def set(key: String, value: String = ""): Unit = storage.setItem(key, value)

  def set(map: HashMap[String, String]): Unit = map.foreach(kvp => set(kvp._1, kvp._2))

  def get(key: String): Option[String] = Option(storage.getItem(key))

  def has(key: String): Boolean = get(key).isDefined

  def removeItem(key: String): Unit = if (has(key)) storage.removeItem(key)

  def clear = storage.clear()

  def +=(kvp: (String, String)) = set(kvp._1, kvp._2)

  def -=(key: String) = removeItem(key)
}

