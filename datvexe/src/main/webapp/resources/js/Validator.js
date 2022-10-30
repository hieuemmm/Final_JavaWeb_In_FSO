// Đối tượng `Validator`
function Validator(options) {
    function getParent(element, selector) {
		if(element){
			 while (element.parentElement) {
	            if (element.parentElement.matches(selector)) {
	                return element.parentElement;
	            }
	            element = element.parentElement;
	        }
		}
    }

    var selectorRules = {};

    // Hàm thực hiện validate
    function validate(inputElement, rule) {
        var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
        var errorMessage;

        // Lấy ra các rules của selector
        var rules = selectorRules[rule.selector];

        // Lặp qua từng rule & kiểm tra
        // Nếu có lỗi thì dừng việc kiểm
        for (var i = 0; i < rules.length; ++i) {
            switch (inputElement.type) {
                case 'radio':
                case 'checkbox':
                    errorMessage = rules[i](
                        formElement.querySelector(rule.selector + ':checked')
                    );
                    break;
                default:
                    errorMessage = rules[i](inputElement.value);
            }
            if (errorMessage) break;
        }

        if (errorMessage) {
            errorElement.innerText = errorMessage;
            getParent(inputElement, options.formGroupSelector).classList.add('invalid');
        } else {
            errorElement.innerText = '';
            getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
        }

        return !errorMessage;
    }

    // Lấy element của form cần validate
    var formElement = document.querySelector(options.form);
    if (formElement) {
        // Khi submit form
        formElement.onsubmit = function (e) {
            e.preventDefault();

            var isFormValid = true;

            // Lặp qua từng rules và validate
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });

            if (isFormValid) {
                // Trường hợp submit với javascript
                if (typeof options.onSubmit === 'function') {
                    var enableInputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {

                        switch (input.type) {
                            case 'radio':
                                values[input.name] = formElement.querySelector('input[name="' + input.name + '"]:checked').value;
                                break;
                            case 'checkbox':
                                if (!input.matches(':checked')) {
                                    values[input.name] = '';
                                    return values;
                                }
                                if (!Array.isArray(values[input.name])) {
                                    values[input.name] = [];
                                }
                                values[input.name].push(input.value);
                                break;
                            case 'file':
                                values[input.name] = input.files;
                                break;
                            default:
                                values[input.name] = input.value;
                        }

                        return values;
                    }, {});
                    options.onSubmit(formValues);
                }
                // Trường hợp submit với hành vi mặc định
                else {
                    formElement.submit();
                }
            }
        }

        // Lặp qua mỗi rule và xử lý (lắng nghe sự kiện blur, input, ...)
        options.rules.forEach(function (rule) {

            // Lưu lại các rules cho mỗi input
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);
            } else {
                selectorRules[rule.selector] = [rule.test];
            }

            var inputElements = formElement.querySelectorAll(rule.selector);

            Array.from(inputElements).forEach(function (inputElement) {
                // Xử lý trường hợp blur khỏi input
                inputElement.onblur = function () {
                    validate(inputElement, rule);
                }

                // Xử lý mỗi khi người dùng nhập vào input
                inputElement.oninput = function () {
                    var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
                    errorElement.innerText = '';
                    getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
                }
            });
        });
    }

}
// Định nghĩa rules
// Nguyên tắc của các rules:
// 1. Khi có lỗi => Trả ra message lỗi
// 2. Khi hợp lệ => Không trả ra cái gì cả (undefined)
Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value ? undefined : message || 'Vui lòng nhập trường này'
        }
    };
}

Validator.ifExitsIsRequired = function (selector, getExitsValue, message) {
    return {
        selector: selector,
        test: function (value) {
			console.log(getExitsValue().length>0);
			if(getExitsValue()){
				return value ? undefined : message || 'Vui lòng nhập trường này';
			}else{
				return "";
			}
        }
    }
}

Validator.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value) ? undefined : message || 'Trường này phải là email';
        }
    };
}

Validator.isNumberPhone = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^((090)|(091)|(\(84\)\+90)|(\(84\)\+91))[0-9]+$/;
            return regex.test(value) ? undefined : message || 'Trường này phải bắt đầu bằng 090, 091, (84)+90 hoặc (84)+91';
        }
    };
}
Validator.isNumberPhoneHas10Has11AndStartWith0 = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            let check = value.startsWith(0) && (value.includes(11) || value.includes(10));
            return check ? undefined : message || 'Trường này phải bắt đầu bằng 090, 091, (84)+90 hoặc (84)+91';
        }
    };
}
Validator.isGreaterThanZero = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return Number(value)>0 ? undefined : message || 'Trường này phải là số nguyên lớn hơn 0';
        }
    };
}
Validator.isGreaterThanOrEqualCurrentDate = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
			let specific_date = new Date(value);
			let current_date = new Date();
            return current_date.getTime() <= specific_date.getTime() ? undefined : message || 'Lớn hơn hoặc bằng ngày hiện tại';
        }
    };
}

Validator.isPattern = function (selector, regex, message) {
    return {
        selector: selector,
        test: function (value) {
            return regex.test(value) ? undefined : message || 'Trường này không hợp lệ';
        }
    };
}

Validator.isLength = function (selector, length, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length == length ? undefined : message || `Vui lòng nhập độ dài đúng bằng ${length} kí tự`;
        }
    };
}

Validator.minLength = function (selector, min, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} kí tự`;
        }
    };
}

Validator.maxLength = function (selector, max, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length <= max ? undefined : message || `Vui lòng nhập tối đa ${max} kí tự`;
        }
    };
}

Validator.isConfirmed = function (selector, getConfirmValue, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === getConfirmValue() ? undefined : message || 'Giá trị nhập vào không chính xác';
        }
    }
}

