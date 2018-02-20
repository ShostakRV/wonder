var path = require('path');
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');

const PATHS = {
    source: path.join(__dirname, 'src'),
    build: path.join(__dirname, 'build')
};

module.exports = {
    entry: [
        PATHS.source + '/index.js'
    ],
    output: {
        path: PATHS.build,
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Boot React',
            template: path.join(__dirname, 'public/index.html')
        })
    ],
    module: {
        loaders: [
            {
                test: /\.jsx$/,
                include: PATHS.source,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ["es2015", "stage-0", "react"]
                }
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                include: PATHS.source,
                loader: 'babel-loader'
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(png|jpg|gif)$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {}
                    }
                ]
            },
            {
                test: /\.(eot|svg|ttf|woff|woff2)$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {}
                    }
                ]
            },
            {
                test: /\.json$/,
                loader: 'raw-loader'
            }
        ],
    }
};
