module.exports = {
  plugins: {
    autoprefixer: {},

    'postcss-preset-env': {
      features: {
        'custom-properties': { preserve: false },
        'nesting-rules': true,
        'custom-media-queries': true
      }
    }
  }
}
