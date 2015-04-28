package com.endava.ict

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def double(t: Tree[Int]): Tree[Int] =
    t match {
      case Leaf(v) =>
        Leaf(v * 2)
      case Branch(left, right) =>
        Branch(double(left), double(right))
    }

  def triple(t: Tree[Int]): Tree[Int] =
    t match {
      case Leaf(v) =>
        Leaf(v * 3)
      case Branch(left, right) =>
        Branch(double(left), double(right))
    }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] =
    t match {
      case Leaf(v) => Leaf(f(v))
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
    }

  def double2(t: Tree[Int]): Tree[Int] =
    map(t)((elem: Int) => 2 * elem)

  def triple2(t: Tree[Int]): Tree[Int] =
    map(t)((elem: Int) => 3 * elem)

  def sum(t: Tree[Int]): Int =
    t match {
      case Leaf(v) => v
      case Branch(left, right) => sum(left) + sum(right)
    }

  def product(t: Tree[Int]): Int =
    t match {
      case Leaf(v) => v
      case Branch(left, right) => product(left) * product(right)
    }

  def size[A](t: Tree[A]): Int =
    t match {
      case Leaf(_) => 1
      case Branch(left, right) => size(left) + size(right)
    }

  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B =
    t match {
      case Leaf(v) => f(v)
      case Branch(left, right) => g(fold(left)(f)(g), fold(right)(f)(g))
    }

  def sum2(t: Tree[Int]): Int =
    fold(t)((elem: Int) => elem)((l, r) => l + r)

  def product2(t: Tree[Int]): Int =
    fold(t)((elem: Int) => elem)((l, r) => l * r)

  def size2(t: Tree[Int]): Int =
    fold(t)((elem: Int) => 1)((l, r) => l + r)

}