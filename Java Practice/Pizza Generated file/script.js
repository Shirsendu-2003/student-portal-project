function generateBill() {
  const pizza = document.getElementById("pizza").value;

  let basePrice = {
    Margherita: 5,
    Pepperoni: 6,
    Veggie: 7
  }[pizza];

  let sizePrice = 0;
  const size = document.querySelector('input[name="size"]:checked').value;
  if (size === "Medium") sizePrice = 2;
  else if (size === "Large") sizePrice = 4;

  const toppings = document.querySelectorAll(".topping:checked");
  const toppingCount = toppings.length;
  const toppingPrice = toppingCount * 1;

  const total = basePrice + sizePrice + toppingPrice;

  document.getElementById("bill").innerHTML = `
    <h3>Bill Summary</h3>
    <p>Pizza: ${pizza} ($${basePrice})</p>
    <p>Size: ${size} (+$${sizePrice})</p>
    <p>Toppings (${toppingCount}): $${toppingPrice}</p>
    <hr>
    <h4>Total: $${total}</h4>
  `;
}
