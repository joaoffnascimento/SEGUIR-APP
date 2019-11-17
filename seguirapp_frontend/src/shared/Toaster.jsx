import React from 'react'
import ReduxToastr from 'react-redux-toastr'
import '../../node_modules/react-redux-toastr/lib/css/react-redux-toastr.min.css'

export default props => (
    <ReduxToastr
        timeOut={3000}
        newestOnTo={false}
        preventDuplicates={false}
        position='top-right'
        transitionIn='fadeIn'
        transitionOut='fadeOut'
        />
)