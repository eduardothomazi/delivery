import './styles.css'
import { ReactComponent as Linkedin} from './Linkedin.svg'
import { ReactComponent as Github} from './Github.svg'

function Footer(){
    const linkMainBar="https://github.com"
    return(
        <footer className='home-footer'>
                <div className='footer-img-links'>
                <a className='linkedin-img-link' href="https://linkedin.com/in/eduardo-thomazi91">
                    <Linkedin/>
                </a>
                <a className='github-img-link' href="https://github.com/eduardothomazi">
                    <Github/>
                </a>
            </div>
        </footer>
    )
}

export default Footer