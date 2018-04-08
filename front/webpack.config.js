'use strict';
const webpack = require('webpack')
const path = require('path')

const ExtractTextPlugin = require('extract-text-webpack-plugin')

const extractCss = new ExtractTextPlugin("bundle.min.css");

const config = {
    context: path.resolve(__dirname, 'src'),
    entry: './index.js',
    devServer: {
        inline: true,
        port: 7777,
        contentBase: __dirname + '/build/'
    },
    output: {
        path: path.resolve(__dirname,'../src/main/resources/static/'),
        // publicPath: "/static/",
        filename: '[name].bundle.js',
        chunkFilename: '[id].chunk.js'
    },
    module: {
        loaders: [
            {
                test: /\.svg$/,
                loader: 'raw-loader'
            },
            {
                test: /\.css$/,
                // exclude: path.resolve(__dirname, 'src/assets'),
                loader: ExtractTextPlugin.extract({
                    fallbackLoader: 'style-loader',
                    loader: 'css-loader',
                }),
                // use: extractCSS.extract([ 'css-loader', 'postcss-loader' ])
            },
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            },
            {
                test: /\.(eot|ttf|woff|woff2)$/,
                loader: 'file-loader?name=public/fonts/[name].[ext]'
            },
            { test: /\.(png|jpg|gif)$/, loader: 'url-loader?limit=8192' }
        ]
    },  plugins: [
        new ExtractTextPlugin({
            filename: "[name].css",
            allChunks: true
        })
    ]
};

module.exports = config;