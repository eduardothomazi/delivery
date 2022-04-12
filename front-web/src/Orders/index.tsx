import { useEffect, useState } from 'react'
import { fetchProducts, saveOrder } from '../api'
import { checkIsSelected } from './helpers'
import OrderLocation from './OrderLocation'
import OrderSummary from './OrderSummary'
import ProductsList from './ProductsList'
import StepsHeader from './StepsHeader'
import './styles.css'
import { OrderLocationData, Product } from './types'
import { toast } from 'react-toastify'


function Order() {
    const [products, setProducts] = useState<Product[]>([])
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([])
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>()
    const totalPrice = selectedProducts.reduce((sum, item) => {
        return sum + item.price
    }, 0)

    useEffect(() => {
        fetchProducts().then(response => setProducts(response.data)).catch(error => console.log(error))
    }, [])

    const handleSelectProduct = (product: Product) => {
        const isAreadySelected = checkIsSelected(selectedProducts, product)

        if (isAreadySelected) {
            const selected = selectedProducts.filter(item => item.id !== product.id)
            setSelectedProducts(selected)
        } else {
            setSelectedProducts(previous => [...previous, product])
        }
    }

    const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }))
        const payload = {
            ...orderLocation!,
            products: productsIds
        }
        saveOrder(payload).then((response) => {
            toast.error(`O pedido foi enviado com sucesso! Nº${response.data.id}`)
            setSelectedProducts([])
        })
            .catch(() => {
                toast.warning('Erro ao enviar o pedido')
            })
    }

    return (
        <div className='orders-container'>
            <StepsHeader />
            <ProductsList
                products={products}
                onSelectProduct={handleSelectProduct}
                selectedProducts={selectedProducts}
            />
            <OrderLocation onChangeLocation={location => setOrderLocation(location)} />
            <OrderSummary
                amount={selectedProducts.length}
                totalPrice={totalPrice}
                onSubmit={handleSubmit}
            />

        </div>
    )
}

export default Order