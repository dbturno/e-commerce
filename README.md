# Springboot E-commerce Demo application

```
git clone https://github.com/dbturno/e-commerce.git

```

## Endpoints for happy path demo

* Add products
  * POST /products
* Delete product
  * DELETE /products/{productId}
* List all/specific products
  * GET /products
  * GET /products/{productId}
* Add empty cart
  * POST /carts
* Add item to cart
  * POST /carts/{cartId}/product/{productId}/?quantity={quantity}
* Delete item from cart
  * DELETE /carts/{cartId}/product/{productId}/?quantity={quantity}
* List all/specific carts
  * DELETE /carts
  * DELETE /carts/{cartId}
* Payment
  * POST /payment/cart/{cartId}/?paymentAmount={paymentAmount}



Thank you! :)