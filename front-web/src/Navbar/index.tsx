import './styles.css'
import {ReactComponent as Logo} from './logo.svg'


function Navbar(){
    const linkMainBar="/"
    return(
        <nav className="main-navbar">
            <a className='logo-img' href={linkMainBar}>
            <Logo/>
            </a>
            <a className='logo-txt' href={linkMainBar}>
                Delivery app
            </a>
        </nav>
    )
}

export default Navbar


