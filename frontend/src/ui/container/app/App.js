import React from 'react';

import {connect} from 'react-redux';

const App = () => {
    return (
        <div>
            <div className="container-fluid">
                <div className="col-xs-offset-2 col-xs-8">
                    <div className="col-xs-12 bg-info">
                        <div className="col-xs-2">ID</div>
                        <div className="col-xs-8">players</div>
                        <div className="col-xs-2">3 column</div>
                    </div>
                    <div className="col-xs-12 ">
                        <div className="col-xs-2">1</div>
                        <div className="col-xs-8">nik 1;nik 2;nik 3</div>
                        <div className="col-xs-2">3 column</div>
                    </div>
                    <div className="col-xs-12 bg-info">
                        <div className="col-xs-2">2</div>
                        <div className="col-xs-8">nik 1;nik 2;nik 5</div>
                        <div className="col-xs-2">3 column</div>
                    </div>
                    <div className="col-xs-12 ">
                        <div className="col-xs-2">3</div>
                        <div className="col-xs-8">nik 1;nik 2;nik 7</div>
                        <div className="col-xs-2">3 column</div>
                    </div>
                    <div className="col-xs-12 bg-info">
                        <div className="col-xs-2">4</div>
                        <div className="col-xs-8">nik 1;nik 2;nik 9</div>
                        <div className="col-xs-2">3 column</div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default connect(
)(App);