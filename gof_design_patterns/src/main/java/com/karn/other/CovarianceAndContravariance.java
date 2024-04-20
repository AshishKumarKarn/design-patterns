package com.karn.other;

public class CovarianceAndContravariance {
}

/**
 * Covariance
 * Supertype accepts more general input than subtype
 * if A:B then I<A>:I<B>, if A is subtype of B, then class using A should be subtype be class using B
 * <p>
 * Be conservative in what you do
 */
class FruitSequence {
    Fruit next() {
        return new Fruit();
    }
}

class OrangeSequence extends FruitSequence {
    @Override
    Orange next() {
        return new Orange();
    }
}

class Fruit {

}

class Orange extends Fruit {

}

/**
 * Contravariance
 * Subtype accepts more general output than super type
 * if A:B then I<B>:I<A>, if A is subtype of B, then class using B should be subtype be class using A
 * <p>
 * Be liberal in what you accept from others
 */
class OrangeJuicer {
    void juice(Orange m) {

    }
}

class FruitJuicer extends OrangeJuicer {

    void juice(Fruit f) {

    }

}
