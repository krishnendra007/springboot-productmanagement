document.getElementById('addProductForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const productName = document.getElementById('productName').value;
    const productType = document.getElementById('productType').value;
    const productPlace = document.getElementById('productPlace').value;
    const productWarranty = document.getElementById('productWarranty').value;

    const product = {
        name: productName,
        type: productType,
        place: productPlace,
        warrenty: productWarranty 
    };

    try {
        await addProduct(product);
        clearAddProductForm(); // Clear the form fields after adding product
    } catch (error) {
        console.error('Error:', error);
    }
});

async function addProduct(product) {
    try {
        const response = await fetch('/product', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
        });
        const data = await response.json();
        console.log('Success:', data);
        getAllProducts();
    } catch (error) {
        throw new Error(error);
    }
}

async function getAllProducts() {
    try {
        const response = await fetch('/products');
        const data = await response.json();
        const productList = document.getElementById('productList');
        productList.innerHTML = '';
        data.forEach(product => {
            const li = document.createElement('li');
            li.textContent = `ID: ${product.id}, Name: ${product.name}, Type: ${product.type}, Place: ${product.place}, Warrenty: Till ${product.warrenty}`;
            productList.appendChild(li);
        });

        setTimeout(() => {
            productList.innerHTML = '';
        }, 7000); // Clear after 7 seconds
    } catch (error) {
        console.error('Error:', error);
    }
}

async function getProductById() {
    const productId = document.getElementById('productId').value;
    try {
        const response = await fetch(`/product/${productId}`);
        const product = await response.json();
        displayProductDetails(product, 'singleProduct');
    } catch (error) {
        console.error('Error:', error);
    }
    setTimeout(() => {
        document.getElementById('singleProduct').textContent = '';
    }, 3000); // Clear after 3 seconds
}

async function getProductByName() {
    const productName = document.getElementById('productNameSearch').value;
    try {
        const response = await fetch(`/productbyname/${productName}`);
        const product = await response.json();
        displayProductDetails(product, 'productByName');
    } catch (error) {
        console.error('Error:', error);
    }
    setTimeout(() => {
        document.getElementById('productByName').textContent = '';
    }, 3000); // Clear after 3 seconds
}

function displayProductDetails(product, elementId) {
    const productElement = document.getElementById(elementId);
    productElement.textContent = `ID: ${product.id}, Name: ${product.name}, Type: ${product.type}, Place: ${product.place}, Warrenty: ${product.warrenty} years`;
    setTimeout(() => {
        productElement.textContent = '';
    }, 3000); // Clear after 3 seconds
}

async function editProduct() {
    const productId = document.getElementById('editProductId').value;
    const productName = document.getElementById('editProductName').value;
    const productType = document.getElementById('editProductType').value;
    const productPlace = document.getElementById('editProductPlace').value;
    const productWarranty = document.getElementById('editProductWarranty').value;

    const product = {
        name: productName,
        type: productType,
        place: productPlace,
        warrenty: productWarranty 
    };

    try {
        await fetch(`/product/${productId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
        });
        getAllProducts();
    } catch (error) {
        console.error('Error:', error);
    }
    setTimeout(() => {
        getAllProducts();
    }, 3000); // Refresh after 3 seconds
}

async function deleteProduct() {
    const productId = document.getElementById('deleteProductId').value;

    try {
        const response = await fetch(`/product/${productId}`, {
            method: 'DELETE'
        });
        const data = await response.json();
        console.log('Deleted:', data);
        const deleteStatus = document.getElementById('deleteStatus');
        deleteStatus.textContent = `Deleted Product ID: ${data.id}, Name: ${data.name}, Type: ${data.type}, Place: ${data.place}, Warrenty: ${data.warrenty} years`;
        getAllProducts();
    } catch (error) {
        console.error('Error:', error);
    }
    setTimeout(() => {
        getAllProducts();
    }, 3000); // Refresh after 3 seconds
}

function clearAddProductForm() {
    document.getElementById('productName').value = '';
    document.getElementById('productType').value = '';
    document.getElementById('productPlace').value = '';
    document.getElementById('productWarranty').value = '';
}

// Initial call to getAllProducts
getAllProducts();
