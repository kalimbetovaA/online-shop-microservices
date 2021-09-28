Project Topic: Online Store of electronic equipment

Description: Our project will be an Online Store of electronic equipment, where customers can select and order the product they want from the list. Products, or rather electronic equipment, will be grouped into categories for convenience. Customers can temporarily store items in their shopping cart until ordering. Also in our online store there will be placement of electronic equipment from stores that are engaged in offline sale of electronic equipment.

Microservices:

Kalimbetova Aray(described):
ProductService:
  Product Information (Name, description, price, in_stock etc)
ProductCategoryService: 
  Product Categories (category name, tag etc)
ShoppingCartService: 
  Products which planned to buy, customers can add additional products or remove products from cart (products list, each product count, sum, discount)

Abibulla Yershat(described):
CustomerService: 
  Contains basic customer information for authentification (Id, Username, password etc) and wallet at the Online Store (tenge)
OrderService: 
  The Service contains information about ordered products, customers who order, delivery address, total sum, payment status, etc.
ShopService: 
  Information about all shops in the online store, the products of which we provide (Name, provided products etc)


Customer service: 
POST method for authentication
GET method for search by id

Product service: 
GET method for search by id, name, price

Product category service: 
GET method for search by category

Order service: 
POST method for add Product for tracking/history

Shopping cart service:
POST method for add Product to card
DELETE method for delete Product from card

Shop service:
POST method for add Product to shop
PUT method for change count and price
DELETE method for delete Product from shop
