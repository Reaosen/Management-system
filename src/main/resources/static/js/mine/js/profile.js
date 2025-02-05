import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'
import Cookies from 'https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.mjs';
import jwtUtils from '/js/mine/utils/jwtUtils.js';

const personal = createApp({
    data() {
        return {
            token: null,
            name: null
        }
    },
}).mount("#personal");